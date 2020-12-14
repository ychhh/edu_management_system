package com.ychhh.edu_management_system.dto;

import com.ychhh.edu_management_system.entity.SysDept;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysDeptDTO extends SysDept {
    private List<SysDeptDTO> list;
    public static SysDeptDTO getSysDeptDTO(SysDept sysDept){
        SysDeptDTO sysDeptDTO=new SysDeptDTO();
        BeanUtils.copyProperties(sysDept,sysDeptDTO);
        return sysDeptDTO;
    }
}
