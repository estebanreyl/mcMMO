package com.gmail.nossr50.config;

import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.datatypes.skills.subskills.AbstractSubSkill;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.StringUtils;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class CoreSkillsConfig extends Config {
    public static final String ENABLED = "Enabled";
    //private static CoreSkillsConfig instance;

    public CoreSkillsConfig() {
        //super(McmmoCore.getDataFolderPath().getAbsoluteFile(),"coreskills.yml", true);
        super("coreskills", mcMMO.p.getDataFolder().getAbsoluteFile(), ConfigConstants.RELATIVE_PATH_CONFIG_DIR, true, true, true, true);
    }

    /**
     * This grabs an instance of the class from the Config Manager
     * This method is deprecated and will be removed in the future
     *
     * @return the instance of this config
     * @see mcMMO#getConfigManager()
     * @deprecated Please use mcMMO.getConfigManager() to grab a specific config instead
     */
    @Deprecated
    public static CoreSkillsConfig getInstance() {
        return mcMMO.getConfigManager().getCoreSkillsConfig();
    }

    /**
     * The version of this config
     *
     * @return
     */
    @Override
    public double getConfigVersion() {
        return 1;
    }

    /*
     * Skill Settings
     */

    /**
     * Whether or not a skill is enabled
     * Defaults true
     *
     * @param abstractSubSkill SubSkill definition to check
     * @return true if subskill is enabled
     */
    public boolean isSkillEnabled(AbstractSubSkill abstractSubSkill) {
        return getBooleanValue(StringUtils.getCapitalized(abstractSubSkill.getPrimarySkill().toString()), abstractSubSkill.getConfigKeyName(), ENABLED);
    }

    /**
     * Whether or not this primary skill is enabled
     *
     * @param primarySkillType target primary skill
     * @return true if enabled
     */
    public boolean isPrimarySkillEnabled(PrimarySkillType primarySkillType) {
        return getBooleanValue(StringUtils.getCapitalized(primarySkillType.toString()), ENABLED);
    }
}
