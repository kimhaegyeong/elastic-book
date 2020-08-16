package io.javacafe.client.rest;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Example02 {
    /**
     * 인덱스 삭제
     * */
    public static void main(String[] args) throws IOException {
        
    	RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));

        // Index명
        String INDEX_NAME = "movie_rest";
        
        
        // 인덱스 삭제
        DeleteIndexRequest request = new DeleteIndexRequest(INDEX_NAME);

        org.elasticsearch.action.support.master.AcknowledgedResponse response = 
        		client.indices().delete(request,RequestOptions.DEFAULT);
        		
        boolean acknowledged = response.isAcknowledged();		
        
        client.close();
    }
}
