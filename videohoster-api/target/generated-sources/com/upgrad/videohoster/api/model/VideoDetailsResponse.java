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
 * VideoDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-16T17:58:16.128+05:30")

public class VideoDetailsResponse   {
  @JsonProperty("video")
  private String video = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  private String status = null;

  public VideoDetailsResponse video(String video) {
    this.video = video;
    return this;
  }

  /**
   * This is url of video
   * @return video
  **/
  @ApiModelProperty(required = true, value = "This is url of video")
  @NotNull


  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public VideoDetailsResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the user in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the user in a standard UUID format")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public VideoDetailsResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the video
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the video")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public VideoDetailsResponse description(String description) {
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

  public VideoDetailsResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Video is active
   * @return status
  **/
  @ApiModelProperty(required = true, value = "Video is active")
  @NotNull


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
    VideoDetailsResponse videoDetailsResponse = (VideoDetailsResponse) o;
    return Objects.equals(this.video, videoDetailsResponse.video) &&
        Objects.equals(this.id, videoDetailsResponse.id) &&
        Objects.equals(this.name, videoDetailsResponse.name) &&
        Objects.equals(this.description, videoDetailsResponse.description) &&
        Objects.equals(this.status, videoDetailsResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(video, id, name, description, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VideoDetailsResponse {\n");
    
    sb.append("    video: ").append(toIndentedString(video)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

