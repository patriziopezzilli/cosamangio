package com.cosamangio.service;

import com.cosamangio.dto.LatLong;
import com.cosamangio.dto.merchant.CreateMerchantRequest;
import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.entity.SocialEntity;
import com.cosamangio.mapper.MerchantMapper;
import com.cosamangio.repository.MerchantRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MerchantService {

    private final Random rand = new Random();
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;
    private final LocalizationService localizationService;
    private final VatService vatService;
    private final UploaderFTPService uploaderFTPService;

    public MerchantService(MerchantRepository merchantRepository, MerchantMapper merchantMapper, LocalizationService localizationService, VatService vatService, UploaderFTPService uploaderFTPService) {
        this.merchantRepository = merchantRepository;
        this.merchantMapper = merchantMapper;
        this.localizationService = localizationService;
        this.vatService = vatService;
        this.uploaderFTPService = uploaderFTPService;
    }


    /**
     * Create new merchant
     *
     * @param request
     */
    public void createMerchant(CreateMerchantRequest request) {
        MerchantEntity entity = new MerchantEntity();

        /**
         * Init common fields
         */
        entity.setCode(UUID.randomUUID().toString());
        entity.setEmail(request.getEmail());
        entity.setName(request.getName());
        entity.setShortName(request.getName());
        entity.setVatCode(request.getVatCode());
        entity.setDescription("");
        entity.setPassword("");
        entity.setAddress(request.getAddress());
        entity.setPhotoUrl("");

        /**
         * Retrieve lat and long
         */
        LatLong latLong = localizationService.getPosition(request.getAddress());
        entity.setLatitude(latLong.getLatitude());
        entity.setLongitude(latLong.getLongitude());

        /**
         * Set validation code
         */
        entity.setValidated(true);
        entity.setValidationCode(String.valueOf(rand.nextInt(10000)));

        /**
         * Set active
         */
        entity.setActive(false);

        /**
         * Set arrays
         */
        entity.setAllergens(new ArrayList<>());
        entity.setTags(new ArrayList<>());
        entity.setSocials(new ArrayList<>());
        entity.setMenus(new ArrayList<>());

        /**
         * Save
         */
        merchantRepository.save(entity);
    }

    /**
     * Retrieve all merchants configured on *cosamangio*
     *
     * @return
     */
    public List<Merchant> findAll() {
        List<MerchantEntity> entities = merchantRepository.findByActive(true);

        return merchantMapper.mapToDtos(entities);
    }

    public void updateName(String merchantCode, String name) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        merchantEntity.setName(name);
        merchantEntity.setShortName(name);
        merchantRepository.save(merchantEntity);
    }

    public void updateDescription(String merchantCode, String description) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        merchantEntity.setDescription(description);
        merchantRepository.save(merchantEntity);
    }

    public void updateAddress(String merchantCode, String address) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        merchantEntity.setAddress(address);
        LatLong latLong = localizationService.getPosition(address);
        merchantEntity.setLatitude(latLong.getLatitude());
        merchantEntity.setLongitude(latLong.getLongitude());
        merchantRepository.save(merchantEntity);
    }

    /**
     * Find by one
     *
     * @param email
     * @return
     */
    public Merchant findOne(String email) {
        return merchantMapper.mapToDto(merchantRepository.findByEmail(email));
    }

    public void updateSocial(String merchantCode, String socialCode, String name, String url) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        boolean updated = false;
        if (merchantEntity != null & merchantEntity.getSocials() != null) {
            for (SocialEntity social : merchantEntity.getSocials()) {
                if (social.getCode().equalsIgnoreCase(socialCode)) {
                    social.setName(name);
                    social.setUrl(url);
                    updated = true;
                }
            }

            if (!updated) {
                SocialEntity newSocial = new SocialEntity();
                newSocial.setName(name);
                newSocial.setCode(socialCode);
                newSocial.setUrl(url);

                merchantEntity.getSocials().add(newSocial);
            }

            merchantRepository.save(merchantEntity);
        }
    }


    public void editAllergens(String merchantCode, List<String> allergens) {
        List<String> newAllergensList = new ArrayList<>();

        for (String allergen : allergens) {
            switch (allergen) {
                case "Cereali":
                    newAllergensList.add("cereal");
                    break;
                case "Molluschi":
                    newAllergensList.add("mullusc");
                    break;
                case "Uova":
                    newAllergensList.add("egg");
                    break;
                case "Pesce":
                    newAllergensList.add("fish");
                    break;
                case "Arachidi":
                    newAllergensList.add("peanuts");
                    break;
                case "Soia":
                    newAllergensList.add("soy");
                    break;
                case "Latte":
                    newAllergensList.add("milk");
                    break;
                case "Frutta a guscio":
                    newAllergensList.add("fruit");
                    break;
                case "Sedano":
                    newAllergensList.add("celery");
                    break;
                case "Senape":
                    newAllergensList.add("mustard");
                    break;
                case "Sesamo":
                    newAllergensList.add("sesam");
                    break;
                case "Lupini":
                    newAllergensList.add("lupins");
                    break;
                case "Anidride Solforosa":
                    newAllergensList.add("sulphi");
                    break;
                case "Crostacei":
                    newAllergensList.add("crosta");
                    break;
                default:
                    break;
            }

            MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
            merchantEntity.setAllergens(newAllergensList);
            merchantRepository.save(merchantEntity);
        }
    }

    public void activateMerchant(String merchantCode, Boolean activation) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        merchantEntity.setActive(activation);
        merchantRepository.save(merchantEntity);
    }

    public void uploadLogo(String merchantCode, MultipartFile file) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        uploaderFTPService.upload(file, merchantCode);
        merchantEntity.setPhotoUrl("http://www.ristorantemonopoli.com/ristoranti/" + file.getOriginalFilename());
        merchantRepository.save(merchantEntity);
    }

    public void removeLogo(String merchantCode) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        merchantEntity.setPhotoUrl("");
        merchantRepository.save(merchantEntity);
    }
}
