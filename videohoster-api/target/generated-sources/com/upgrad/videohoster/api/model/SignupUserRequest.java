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
 * SignupUserRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-16T17:58:15.094+05:30")

public class SignupUserRequest   {
  @JsonProperty("first_name")
  private String firstName = null;

  @JsonProperty("last_name")
  private String lastName = null;

  @JsonProperty("email_address")
  private String emailAddress = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("mobile_number")
  private String mobileNumber = null;

  public SignupUserRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the new user
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "First name of the new user")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public SignupUserRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the new user
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "Last name of the new user")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public SignupUserRequest emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email address of the new user
   * @return emailAddress
  **/
  @ApiModelProperty(required = true, value = "Email address of the new user")
  @NotNull


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public SignupUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of the new user
   * @return password
  **/
  @ApiModelProperty(required = true, value = "Password of the new user")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SignupUserRequest mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Mobile number of the new user
   * @return mobileNumber
  **/
  @ApiModelProperty(required = true, value = "Mobile number of the new user")
  @NotNull


  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignupUserRequest signupUserRequest = (SignupUserRequest) o;
    return Objects.equals(this.firstName, signupUserRequest.firstName) &&
        Objects.equals(this.lastName, signupUserRequest.lastName) &&
        Objects.equals(this.emailAddress, signupUserRequest.emailAddress) &&
        Objects.equals(this.password, signupUserRequest.password) &&
        Objects.equals(this.mobileNumber, signupUserRequest.mobileNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress, password, mobileNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignupUserRequest {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
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

