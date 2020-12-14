package com.ychhh.edu_management_system.service.impl;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.ychhh.edu_management_system.dao.SysDeptDao;
import com.ychhh.edu_management_system.dto.SysDeptDTO;
import com.ychhh.edu_management_system.entity.SysDept;
import com.ychhh.edu_management_system.service.SysDeptService;
import com.ychhh.edu_management_system.utils.ResponseException;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import com.ychhh.edu_management_system.vo.SysDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    SysDeptDao sysDeptDao;

    @Override
    public SysDeptDTO getTree() {
        List<SysDept> sysDepts=sysDeptDao.selectAll();
        List<SysDeptDTO> sysDeptDTOs=new ArrayList<>();
        for (SysDept sysDept:sysDepts){
            SysDeptDTO sysDeptDTO=SysDeptDTO.getSysDeptDTO(sysDept);
            sysDeptDTOs.add(sysDeptDTO);
        }
        List<SysDept> sysDeptList=sysDeptDao.selectByParentId(0l);
        if (sysDeptList.size()==0){
            return null;
        }
        SysDeptDTO root=SysDeptDTO.getSysDeptDTO(sysDeptList.get(0));
        return generateTree(sysDeptDTOs,root);
    }

    public SysDeptDTO generateTree(List<SysDeptDTO> sysDeptDTOs,SysDeptDTO root){
        List<SysDeptDTO> sysDeptDTOList= sysDeptDTOs.stream().filter(item -> item.getParentId().equals(root.getId())).collect(Collectors.toList());
        root.setList(sysDeptDTOList);
        for (SysDeptDTO sysDeptDTO:root.getList()){
            generateTree(sysDeptDTOs,sysDeptDTO);
        }
        return root;
    }
    @Override
    public int deleteByPrimaryKey(Long id) {
        sysDeptDao.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(SysDeptVO sysDeptVO, HttpServletRequest request) {
        SysDept sysDept=SysDept.getSysDept(sysDeptVO);
        isExistSameName(sysDeptVO.getParentId(),sysDeptVO.getName());
        sysDept.setOperateTime(new Date());
        sysDept.setOperator("管理员");
        String remoteAddr=request.getRemoteAddr();
        sysDept.setOperateIp(remoteAddr);
        sysDeptDao.insert(sysDept);
        return 0;
    }

    @Override
    public SysDept selectByPrimaryKey(Long id) {
        return sysDeptDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(SysDeptVO sysDeptVO ,HttpServletRequest request){
        SysDept sysDept=SysDept.getSysDept(sysDeptVO);
        isExistSameName(sysDeptVO.getParentId(),sysDeptVO.getName());
        sysDept.setOperateTime(new Date());
        sysDept.setOperator("管理员");
        String remoteAddr=request.getRemoteAddr();
        sysDept.setOperateIp(remoteAddr);
        sysDeptDao.updateByPrimaryKey(sysDept);
        return 0;
    }

    public boolean isExistSameName(Long parentId,String name) {
        List<SysDept> list= sysDeptDao.selectByParentIdAndName(parentId,name);
        if (list.size()>=1) {
            throw ResponseException.myException(10000, "同一层级下存在名称相同的部门");
        }
        return true;
    }
}
