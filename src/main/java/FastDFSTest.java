/**
 * Copyright (C), 2015-2019, 宜百万有限公司
 * FileName: FastDFSTest
 * Author:   Administrator
 * Date:     2019/3/15 17:52
 */

import org.csource.fastdfs.*;

/**
 * @author Administrator
 * @create 2019/3/15
 */
public class FastDFSTest {

    public static void main(String[] args) throws Exception {

        //编码思路：
        //1、复制tracker.conf配置文件到resources目录，然后加载配置文件(ClientGlobal.init方法加载)

        ClientGlobal.init("E:\\code\\it\\pinyougou-demo\\fastDFS-demo\\src\\main\\resources\\fdfs_client.conf");


        //2、创建一个TrackerClient对象。直接new一个。

        TrackerClient trackerClient = new TrackerClient();
        //3、使用TrackerClient对象创建连接，getConnection获得一个TrackerServer对象。

        TrackerServer conn = trackerClient.getConnection();
        //4、创建一个StorageServer的引用，值为null，为接下来创建StorageClient使用

        StorageServer server = null;

        //5、创建一个StorageClient对象，直接new一个，需要两个参数TrackerServer对象、StorageServer的引用

        StorageClient storageClient = new StorageClient(conn,server);
        //6、使用StorageClient对象upload_file方法上传图片，使用3个参数的， 扩展名不带“.”。

        String[] upload_appender_file = storageClient.upload_appender_file("F:\\bf.jpg", "jpg", null);

        //7、返回数组。包含组名和图片的路径，打印结果。

        for (String file : upload_appender_file) {

            System.out.println(file);
        }


    }

}