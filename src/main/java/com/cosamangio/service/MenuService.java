package com.cosamangio.service;

import com.cosamangio.dto.menu.Menu;
import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.entity.SectionEntity;
import com.cosamangio.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService {
    private final MerchantRepository merchantRepository;

    public MenuService(MerchantRepository repository) {
        this.merchantRepository = repository;
    }

    public void deleteAllMenu(String merchantCode) {
        MerchantEntity toDelete = merchantRepository.findByCode(merchantCode);
        toDelete.setMenus(new ArrayList<>());
        merchantRepository.save(toDelete);
    }

    public void deleteMenu(String merchantCode, String menuName) {
        MerchantEntity toDelete = merchantRepository.findByCode(merchantCode);
        List<MenuEntity> newMenuList = new ArrayList<>();
        if (null != toDelete && toDelete.getMenus() != null) {
            for (MenuEntity menu : toDelete.getMenus()) {
                if (!menu.getName().equals(menuName)) {
                    newMenuList.add(menu);
                }
            }

            toDelete.setMenus(newMenuList);
            merchantRepository.save(toDelete);
        }
    }

    public void updateMenuName(String merchantCode, String oldName, String menuName) {
        MerchantEntity toUpdate = merchantRepository.findByCode(merchantCode);
        if (null != toUpdate && toUpdate.getMenus() != null) {
            for (MenuEntity menu : toUpdate.getMenus()) {
                if (menu.getName().equals(oldName)) {
                    menu.setName(menuName);
                    menu.setLastUpdateDate(new Date());
                }
            }

            merchantRepository.save(toUpdate);
        }
    }

    public void createMenu(String merchantCode, String name, List<String> sections) {
        MerchantEntity toUpdate = merchantRepository.findByCode(merchantCode);
        MenuEntity newMenu = new MenuEntity();
        newMenu.setCode(UUID.randomUUID().toString());
        newMenu.setCreationDate(new Date());
        newMenu.setLastUpdateDate(new Date());
        newMenu.setName(name);
        newMenu.setSections(new ArrayList<>());

        if (sections != null) {
            for (String section : sections) {
                SectionEntity entity = new SectionEntity();
                entity.setCode(UUID.randomUUID().toString());
                entity.setItemList(new ArrayList<>());
                entity.setName(section);

                newMenu.getSections().add(entity);
            }
        }

        toUpdate.getMenus().add(newMenu);
        merchantRepository.save(toUpdate);
    }
}
