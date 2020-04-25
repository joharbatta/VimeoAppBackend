package com.upgrad.videohoster.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateVideoResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-16T17:58:16.128+05:30")

public class UpdateVideoResponse   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("status")
  private String status = null;

  public UpdateVideoResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of the video
   * @return id
  **/
  @ApiModelProperty(value = "id of the video")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UpdateVideoResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the video
   * @return status
  **/
  @ApiModelProperty(value = "Status of the video")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateVideoResponse updateVideoResponse = (UpdateVideoResponse) o;
    return Objects.equals(this.id, updateVideoResponse.id) &&
        Objects.equals(this.status, updateVideoResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateVideoResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

