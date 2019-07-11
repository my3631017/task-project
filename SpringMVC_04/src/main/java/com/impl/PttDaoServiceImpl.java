package com.impl;

import com.dao.PttDao;
import com.pojo.Profession;
import com.service.PttDaoService;

import java.util.List;

public class PttDaoServiceImpl implements PttDaoService {
    private PttDao pttDao;

    public void setPttDao(PttDao pttDao) {
        this.pttDao = pttDao;
    }

    @Override
    public Profession findProfession(String profession) throws Exception {
        Profession profession1 = pttDao.findProfessionByName(profession);
        return profession1;
    }

    @Override
    public List<Profession> findAll() throws Exception {
        List<Profession> list = pttDao.findProfessionNumber();
        return list;
    }
}
