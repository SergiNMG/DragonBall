package com.fpmislata.dragonball.http_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@JsonPropertyOrder({"total_records", "page", "page_size", "total_pages", "next", "previous", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("response")
public class Response {

    private Object data;
    @JsonProperty("total records")
    private long total_records;
    private Integer page;
    @JsonProperty("page size")
    private Integer page_size;
    @JsonProperty("total pages")
    private Integer total_pages;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;

    @Value("${app.url}")
    private String url;

    @Value("${buildPagination.defaultPageSize}")
    private Integer page_size_default;

    public Response(Object data, long total_records, Integer page, Integer page_size, String url){
        this.data = data;
        this.total_records = total_records;
        this.url = url;
        if (page != null){
            buildPaginationMetaData(total_records, page_size, page, url);
        }
    }

    private void buildPaginationMetaData(long total_records, int page, int page_size, String url){
        this.page = page;
        this.page_size = page_size;
        int total_pages = (int) (Math.ceil((double) total_records / page_size));
        this.total_pages = total_pages;

        if(page > 1 && total_pages > 1){
            this.previous = url + "?page=" + (page - 1);
        }
        if (page < total_pages){
            this.next = url + "?page=" + (page + 1);
        }
    }
}
