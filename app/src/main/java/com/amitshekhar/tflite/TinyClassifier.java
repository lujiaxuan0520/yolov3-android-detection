package com.amitshekhar.tflite;

import android.content.res.AssetManager;
import java.io.IOException;

// yolo-v3 tiny
public class TinyClassifier extends Classifier {

    protected float mObjThresh;

    public TinyClassifier(AssetManager assetManager) throws IOException{
        //super(assetManager, "yolov3-tiny-own-small-network.tflite", "my_tiny_shared_bike.txt", 416); //10M小模型，对应mObjThresh为0.02
        super(assetManager, "yolov3-tiny-own-roadLine-and-license.tflite", "my_tiny_shared_bike.txt", 416);
        mAnchors = new int[]{
                10,14,  23,27,  37,58, 81,82,  135,169,  344,319
        };

//        mMasks = new int[][]{{3,4,5},{0,1,2}};//原代码中设置
        mMasks = new int[][]{{3,4,5},{1,2,3}};
        mOutWidth = new int[]{13,26};//需要注意是否与yad2k所生成的模型网络结构图中最后2个分支的输出值相同
        mObjThresh = 0.1f;//置信度阈值
    }

    @Override
    protected float getObjThresh() {
        return mObjThresh;
    }
}
