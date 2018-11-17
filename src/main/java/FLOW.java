import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author zhangran
 * @since 2018-07-10
 **/
public class FLOW {
    public static void main(String[] args) throws InterruptedException {
        //1 定义发布者
        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();

        //2. 定义订阅者

        Subscriber<Integer> subscriber = new Subscriber<>() {

            private Subscription subscription;
            private int count = 0;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }


            @Override
            public void onNext(Integer item) {
                count++;
                System.out.println("接受数据" + item);

                if (count > 500) {
                    throw new IllegalArgumentException("sdf");
                }
                subscription.request(100);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("on error");
                throwable.printStackTrace();
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("处理完成");
            }
        };
        submissionPublisher.subscribe(subscriber);

        for (int i = 0; i < 1000; i++) {
            System.out.println("生产数据:" + i);
            submissionPublisher.submit(i);
        }
        submissionPublisher.close();

        Thread.currentThread().join(15000);
    }

}
