//package cn.skuu.ai;
//
//import com.alibaba.dashscope.audio.tts.SpeechSynthesisAudioFormat;
//import com.alibaba.dashscope.audio.tts.SpeechSynthesisParam;
//import com.alibaba.dashscope.audio.tts.SpeechSynthesisResult;
//import com.alibaba.dashscope.audio.tts.SpeechSynthesizer;
//import com.alibaba.dashscope.common.ResultCallback;
//import com.google.common.collect.Lists;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
///**
// * TODO
// *
// * @author dcx
// * @since 2024-02-27 13:17
// **/
//public class VoiceAi {
//
//    public static void syncAudioDataToFile() {
//
//        /**
//         *
//         * 1.萝莉女声 sambert-zhiwei-v1
//         * 2.浙普女声 sambert-zhina-v1
//         * 3.软萌童声 sambert-zhiying-v1
//         * 4.直播女声 sambert-zhigui-v1
//         * 5.多种情感女声 sambert-zhimiao-emo-v1
//         * 6.直播女声 sambert-zhimao-v1
//         **/
//
//        List<String> vods = Lists.newArrayList(
//                "sambert-zhiwei-v1",
//                "sambert-zhina-v1",
//                "sambert-zhiying-v1",
//                "sambert-zhigui-v1",
//                "sambert-zhimiao-emo-v1",
//                "sambert-zhimao-v1"
//        );
//
//        for (String vod : vods) {
//            SpeechSynthesizer synthesizer = new SpeechSynthesizer();
//            SpeechSynthesisParam param = SpeechSynthesisParam.builder()
//                    .model(vod)
//                    .text("我最喜欢的一句话是：“一分耕耘，一分收获。”因为只有付出努力，才能获得回报。")
//                    .sampleRate(48000)
//                    .format(SpeechSynthesisAudioFormat.WAV)
//                    .apiKey("sk-82bf5a7ca474491b8e612702ae498772")
//                    .build();
//
//            File file = new File(vod + "-output.wav");
//            // 调用call方法，传入param参数，获取合成音频
//            ByteBuffer audio = synthesizer.call(param);
//            try (FileOutputStream fos = new FileOutputStream(file)) {
//                fos.write(audio.array());
//                System.out.println("synthesis done!");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        syncAudioDataToFile();
//        System.exit(0);
//    }
//
//    public static void main1(String[] args) {
//        CountDownLatch latch = new CountDownLatch(1);
//        SpeechSynthesizer synthesizer = new SpeechSynthesizer();
//        SpeechSynthesisParam param = SpeechSynthesisParam.builder()
//                .model("sambert-zhichu-v1")
//                .text("今天天气怎么样")
//                .sampleRate(48000)
//                .enableWordTimestamp(true)
//                .enablePhonemeTimestamp(true)
//                .apiKey("sk-82bf5a7ca474491b8e612702ae498772")
//                .build();
//
//        class ReactCallback extends ResultCallback<SpeechSynthesisResult> {
//
//            @Override
//            public void onEvent(SpeechSynthesisResult result) {
//                if (result.getAudioFrame() != null) {
//                    // do something with the audio frame
//                    System.out.println("audio result length: " + result.getAudioFrame().array().length);
//                }
//                if (result.getTimestamp() != null) {
//                    // do something with the timestamp
//                    System.out.println("tiemstamp: " + result.getTimestamp());
//                }
//            }
//
//            @Override
//            public void onComplete() {
//                // do something when the synthesis is done
//                System.out.println("onComplete!");
//                latch.countDown();
//            }
//
//            @Override
//            public void onError(Exception e) {
//                // do something when an error occurs
//                System.out.println("onError:" + e);
//                latch.countDown();
//            }
//        }
//
//        synthesizer.call(param, new ReactCallback());
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.exit(0);
//    }
//}
