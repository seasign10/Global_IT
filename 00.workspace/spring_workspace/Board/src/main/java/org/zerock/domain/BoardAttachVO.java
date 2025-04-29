package org.zerock.domain;

import lombok.Data;

@Data
public class BoardAttachVO {
  private String uuid;
  private String uploadPath;
  private String fileName;
  private boolean fileType; // type이 boolean인 경우 getTypeFile()이 아니라 isTypeFile()로 생성 됨
  
  private Long bno;
  
}
