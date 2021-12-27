package com.jfeat.am.module.evaluation.services.crud.filter;

import com.jfeat.am.module.evaluation.services.persistence.model.StockEvaluationStar;
import com.jfeat.crud.plus.CRUDFilter;


/**
 * Created by Code Generator on 2018-07-16
 */
public class StockEvaluationStarFilter implements CRUDFilter<StockEvaluationStar> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(StockEvaluationStar entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
