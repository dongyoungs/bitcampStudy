// FileInputStream 활용 - JPEG 파일 읽기
package com.eomcs.io.ex02;

import java.io.File;
import java.io.FileInputStream;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;

public class Exam0420 {

  public static void main(String[] args) throws Exception {

    // 1) 파일 정보를 준비한다.
    File file = new File("sample/gps-test.jpeg");

    // 2) 파일을 읽을 도구를 준비한다.
    FileInputStream in = new FileInputStream(file);

    Metadata metadata = ImageMetadataReader.readMetadata(file);
    //    for (Directory directory : metadata.getDirectories()) {
    //      for (Tag tag : directory.getTags()) {
    //        System.out.println(tag);
    //      }
    //    }
    GpsDirectory gpsDirectory =  metadata.getFirstDirectoryOfType(GpsDirectory.class);
    if (gpsDirectory != null) {
      System.out.println(gpsDirectory.getGeoLocation().getLatitude());
      System.out.println(gpsDirectory.getGeoLocation().getLongitude());
    }


  }

}
