package com.gmail.nossr50.core;

import com.gmail.nossr50.mcMMO;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

/**
 * Manages a collection of whitelisted materials for Double Drops
 */
public class BonusDropManager {

    private HashMap<Material, Boolean> bonusDropWhitelist;

    public BonusDropManager() {
        bonusDropWhitelist = new HashMap<>();

        //Start by setting all Materials to false to avoid null checks
        for (Material material : Material.values()) {
            registerMaterial(material, false);
        }
    }

    public void unload() {
        bonusDropWhitelist.clear();
    }

    /**
     * Adds materials to the bonus drop whitelist
     *
     * @param materials target material list
     */
    public void addToWhitelistByMaterial(List<Material> materials) {
        for (Material material : materials) {
            registerMaterial(material, true);
        }
    }

    /**
     * Adds materials to the bonus drop whitelist
     *
     * @param materials target material list
     */
    public void addToWhitelistByNameID(List<String> materials) {
        for (String material : materials) {
            Material m = Material.matchMaterial(material);
            if (m == null) {
                mcMMO.p.getLogger().severe("Error registering Bonus Drop -- Invalid Minecraft Name ID: " + material);
                continue;
            }

            registerMaterial(m, true);
        }
    }

    /**
     * Adds a material to the bonus drop whitelist
     *
     * @param material target material
     */
    private void registerMaterial(Material material, boolean isWhitelisted) {
        bonusDropWhitelist.put(material, isWhitelisted);
    }

    /**
     * Check if a material can provide bonus drops
     *
     * @param material target material
     * @return true if the material can provide bonus drops
     */
    public boolean isBonusDropWhitelisted(Material material) {
        return bonusDropWhitelist.get(material);
    }
}
