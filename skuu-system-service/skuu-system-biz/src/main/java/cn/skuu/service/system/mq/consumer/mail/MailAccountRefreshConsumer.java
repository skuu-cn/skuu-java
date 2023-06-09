package cn.skuu.service.system.mq.consumer.mail;

import cn.iocoder.yudao.framework.mq.core.pubsub.AbstractChannelMessageListener;
import cn.skuu.service.system.mq.message.mail.MailAccountRefreshMessage;
import cn.skuu.service.system.service.mail.MailAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link MailAccountRefreshMessage} 的消费者
 *
 * @author wangjingyi
 */
@Component
@Slf4j
public class MailAccountRefreshConsumer extends AbstractChannelMessageListener<MailAccountRefreshMessage> {

    @Resource
    private MailAccountService mailAccountService;

    @Override
    public void onMessage(MailAccountRefreshMessage message) {
        log.info("[onMessage][收到 Mail Account 刷新信息]");
        mailAccountService.initLocalCache();
    }

}
