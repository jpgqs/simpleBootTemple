package com.wuxg.ex.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


@TableName("t_client_version_statistic")
public class LogStatistics {

  private   Long id;
  private   Date time;
  private   String version;
  private   Long total;

  public LogStatistics() {
  }

  public LogStatistics(Date time, String version, Long total) {
    this.time = time;
    this.version = version;
    this.total = total;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "LogStatistics{" +
            "id=" + id +
            ", time=" + time +
            ", version='" + version + '\'' +
            ", total=" + total +
            '}';
  }
}
