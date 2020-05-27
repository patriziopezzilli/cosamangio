package com.cosamangio.service;

import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.entity.SectionEntity;
import com.cosamangio.entity.SectionItem;
import com.cosamangio.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {

    private final MerchantRepository merchantRepository;

    public SectionService(MerchantRepository repository) {
        this.merchantRepository = repository;
    }

    public void markAvailable(String merchantCode, String sectionCode, String itemCode, Boolean ava) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        if (null != merchantEntity) {
            merchantEntity.getMenus().forEach(m -> {
                m.getSections().forEach(s -> {
                    if (s.getCode().equals(sectionCode)) {
                        s.getItemList().forEach(i -> {
                            if (i.getCode().equals(itemCode)) {
                                i.setAvailable(ava);
                            }
                        });
                    }
                });
            });

            merchantRepository.save(merchantEntity);
        }
    }

    public void createItem(String merchantCode, String sectionCode, String title, String subtitle, String price) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        if (null != merchantEntity) {
            merchantEntity.getMenus().forEach(m -> {
                m.getSections().forEach(s -> {
                    if (s.getCode().equals(sectionCode)) {
                        SectionItem item = new SectionItem();
                        item.setCode(UUID.randomUUID().toString());
                        item.setTitle(title);
                        item.setSubtitle(subtitle);
                        item.setAvailable(true);
                        item.setDescription("");
                        item.setPrice(price);

                        s.getItemList().add(item);
                    }
                });
            });

            merchantRepository.save(merchantEntity);
        }
    }

    public void editItem(String merchantCode, String itemCode, String title, String subtitle, String price) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        if (null != merchantEntity) {
            merchantEntity.getMenus().forEach(m -> {
                m.getSections().forEach(s -> {
                    s.getItemList().forEach(i -> {
                        if (i.getCode().equals(itemCode)) {
                            i.setTitle(title);
                            i.setSubtitle(subtitle);
                            i.setPrice(price);
                        }
                    });
                });
            });

            merchantRepository.save(merchantEntity);
        }
    }

    public void deleteAllItem(String merchantCode, String sectionCode) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        if (null != merchantEntity) {
            merchantEntity.getMenus().forEach(m -> {
                m.getSections().forEach(s -> {
                    if (s.getCode().equals(sectionCode)) {
                        s.setItemList(new ArrayList<>());
                    }
                });
            });

            merchantRepository.save(merchantEntity);
        }
    }

    public void deleteItem(String merchantCode, String sectionCode, String itemCode) {
        MerchantEntity merchantEntity = merchantRepository.findByCode(merchantCode);
        if (null != merchantEntity) {
            merchantEntity.getMenus().forEach(m -> {
                m.getSections().forEach(s -> {
                    if (s.getCode().equals(sectionCode)) {
                        List<SectionItem> items = new ArrayList<>();
                        s.getItemList().forEach(i -> {
                            if (!i.getCode().equals(itemCode)) {
                                items.add(i);
                            }
                        });
                        s.setItemList(items);
                    }
                });
            });

            merchantRepository.save(merchantEntity);
        }
    }

    public void deleteAllSection(String merchantCode, String menuName) {
        MerchantEntity toDelete = merchantRepository.findByCode(merchantCode);
        if (null != toDelete && toDelete.getMenus() != null) {
            for (MenuEntity menu : toDelete.getMenus()) {
                if (menu.getName().equals(menuName)) {
                    menu.setSections(new ArrayList<>());
                }

                merchantRepository.save(toDelete);
            }
        }
    }

    public void deleteSection(String merchantCode, String menuName, String sectionName) {
        MerchantEntity toDelete = merchantRepository.findByCode(merchantCode);
        if (null != toDelete && toDelete.getMenus() != null) {
            for (MenuEntity menu : toDelete.getMenus()) {
                if (menu.getName().equals(menuName)) {
                    List<SectionEntity> newMenuSectionList = new ArrayList<>();

                    if (menu.getSections() != null) {
                        for (SectionEntity sectionEntity : menu.getSections()) {
                            if (!sectionEntity.getName().equals(sectionName)) {
                                newMenuSectionList.add(sectionEntity);
                            }
                        }

                        menu.setSections(newMenuSectionList);
                    }
                }

                merchantRepository.save(toDelete);
            }
        }
    }

    public void updateSection(String merchantCode, String menuName, String oldName, String newName) {
        MerchantEntity toUpdate = merchantRepository.findByCode(merchantCode);
        if (null != toUpdate && toUpdate.getMenus() != null) {
            for (MenuEntity menu : toUpdate.getMenus()) {
                if (menu.getName().equals(menuName)) {
                    if (null != menu.getSections()) {
                        for (SectionEntity section : menu.getSections()) {
                            if (section.getName().equals(oldName)) {
                                section.setName(newName);
                            }
                        }
                    }
                }
            }

            merchantRepository.save(toUpdate);
        }
    }

    public void createSection(String merchantCode, String menuName, String name) {
        MerchantEntity toUpdate = merchantRepository.findByCode(merchantCode);

        if (null != toUpdate && toUpdate.getMenus() != null) {
            for (MenuEntity menu : toUpdate.getMenus()) {
                if (menu.getName().equals(menuName)) {
                    SectionEntity entity = new SectionEntity();
                    entity.setName(name);
                    entity.setCode(UUID.randomUUID().toString());
                    entity.setItemList(new ArrayList<>());

                    menu.getSections().add(entity);
                }
            }
        }

        merchantRepository.save(toUpdate);
    }
}
