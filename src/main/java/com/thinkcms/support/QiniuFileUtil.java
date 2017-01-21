package com.thinkcms.support;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class QiniuFileUtil {
//	private static String path = "http://7xkeg5.com1.z0.glb.clouddn.com/";
//	private static String qiniuAccess = "vjg4smDe5yFt4bIO8cs5PhUivqbOANPxbskLUgi5";
//	private static String qiniuKey = "_EMy-HZwIsLCN4NRNRU1UX4q301V45FMvEoJNeVb";
//	private static String bucketName = "apicloudcms";

	private static String path = "http://ojtqgrh94.bkt.clouddn.com/";
	private static String qiniuAccess = "FfJ8aW5jOq4ciekZvduMw67GUEzsGT1BFfD-gK2Y";
	private static String qiniuKey = "WfcdCjjZoFvTPEeJsBH9EerRnNdZoPK2q_7y4sk8";
	private static String bucketName = "apicloudcjx";

	public static String upload(MultipartFile file) {
		String fileName = "", extName = "", filePath = "";
		if (null != file && !file.isEmpty()) {
			extName = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf("."));
			fileName = UUID.randomUUID() + extName;
			UploadManager uploadManager = new UploadManager();
			Auth auth = Auth.create(qiniuAccess, qiniuKey);
			String token = auth.uploadToken(bucketName);
			Response r;
			try {
				r = uploadManager.put(file.getBytes(), fileName, token);
				if (r.isOK()) {
					filePath = path + fileName;
				}
			} catch (QiniuException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return filePath;
	}

	public static void deleteQiniuP(String imgPath) {
		Auth auth = Auth.create(qiniuAccess, qiniuKey);
		BucketManager bucketManager = new BucketManager(auth);
		imgPath = imgPath.replace(path, "");
		try {
			bucketManager.delete(bucketName, imgPath);
		} catch (QiniuException e) {
			e.printStackTrace();
		}
	}
	public static void deleteQiniuBatch(List<String> imgPaths) {
		Auth auth = Auth.create(qiniuAccess, qiniuKey);
		BucketManager bucketManager = new BucketManager(auth);
		//创建Batch类型的operations对象
		BucketManager.Batch operations = new BucketManager.Batch();
		for (String imgPath:imgPaths) {
			imgPath = imgPath.replace(path, "");
		    operations.delete(bucketName, imgPath);
		}
		try {
			bucketManager.batch(operations);
		} catch (QiniuException e) {
			e.printStackTrace();
		}
	}
}
