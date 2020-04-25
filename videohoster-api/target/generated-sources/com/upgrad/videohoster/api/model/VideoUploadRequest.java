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
 * VideoUploadRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-16T17:58:15.974+05:30")

public class VideoUploadRequest   {
  @JsonProperty("video")
  private String video = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public VideoUploadRequest video(String video) {
    this.video = video;
    return this;
  }

  /**
   * This is video url
   * @return video
  **/
  @ApiModelProperty(required = true, value = "This is video url")
  @NotNull


  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public VideoUploadRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the video
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the video")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public VideoUploadRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the video
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the video")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoUploadRequest videoUploadRequest = (VideoUploadRequest) o;
    return Objects.equals(this.video, videoUploadRequest.video) &&
        Objects.equals(this.name, videoUploadRequest.name) &&
        Objects.equals(this.description, videoUploadRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(video, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VideoUploadRequest {\n");
    
    sb.append("    video: ").append(toIndentedString(video)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

