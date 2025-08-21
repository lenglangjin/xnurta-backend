package com.leda.core.dto;




import com.leda.entity.LedaActivity;
import com.leda.entity.LedaActivityGroup;

import java.util.List;

/**
 * @desc
 * @auth Frank
 * @date 2024/10/31 9:16
 */
public class LedaActivityAddDTO extends LedaActivity {

    private List<LedaActivityGroup> ledaActivityGroups;

    public List<LedaActivityGroup> getLedaActivityGroups() {
        return ledaActivityGroups;
    }

    public void setLedaActivityGroups(List<LedaActivityGroup> ledaActivityGroups) {
        this.ledaActivityGroups = ledaActivityGroups;
    }
}
