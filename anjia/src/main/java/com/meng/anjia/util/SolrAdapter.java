package com.meng.anjia.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yue
 * @date  2019/3/27
 */
@Component
public class SolrAdapter {
    @Autowired
    SolrClient solrClient;

    public QueryResponse search(String core, String q, String df, int start, int rows) throws Exception{
        SolrQuery params = new SolrQuery();
        // 查询条件
        params.set("q", q);
        // 排序
        params.addSort("id", SolrQuery.ORDER.asc);
        // 分页
        params.setStart(start);
        params.setRows(rows);
        // 默认域
        params.set("df", df);
        // 开启高亮
        params.setHighlight(true);
        // 设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        // 设置后缀
        params.setHighlightSimplePost("</span>");
        return solrClient.query(core, params);
    }
}
