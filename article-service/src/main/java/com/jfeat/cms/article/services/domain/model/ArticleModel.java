package com.jfeat.cms.article.services.domain.model;

import com.jfeat.cms.article.services.persistence.model.Article;
import com.jfeat.cms.article.services.persistence.model.ArticleProductRelation;
import com.jfeat.crud.base.request.Image;

import java.util.List;



/**
 * Created by Code Generator on 2018-07-11
 */
public class ArticleModel extends Article {

        List<Image> image;

        String content;

     /*   List<StockImages> images;

        List<StockTagRelation> stockTagRelation;

        List<StockTag> tags;*/


        List<ArticleProductRelation> productRelations;

        /*//评论总数
        Integer evaluationCount;*/

        // 是否 已点赞

        Integer isFlower;

        // 是否 已收藏
        Integer isFavorite;


        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        /*public Integer getEvaluationCount() {
                return evaluationCount;
        }

        public void setEvaluationCount(Integer evaluationCount) {
                this.evaluationCount = evaluationCount;
        }*/

        public Integer getIsFlower() {
                return isFlower;
        }

        public void setIsFlower(Integer isFlower) {
                this.isFlower = isFlower;
        }

        public Integer getIsFavorite() {
                return isFavorite;
        }

        public void setIsFavorite(Integer isFavorite) {
                this.isFavorite = isFavorite;
        }



        public List<ArticleProductRelation> getProductRelations() {
                return productRelations;
        }

        public void setProductRelations(List<ArticleProductRelation> productRelations) {
                this.productRelations = productRelations;
        }

        public List<Image> getImage() {
                return image;
        }

        public void setImage(List<Image> image) {
                this.image = image;
        }
}
