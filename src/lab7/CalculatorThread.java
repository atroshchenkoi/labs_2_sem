package lab7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculatorThread {
    private ExecutorService executorService;
    private int executorServiceCount;
    private int result = 1;
    private int a;

    static class Task implements Runnable{
        private int result;
        private int i, j;

        public Task(int i, int j) {
            this.j = j;
            this.i = i;
            result = 1;
        }

        public int getResult() {
            return result;
        }

        @Override
        public void run() {
            for (int k = i; k <= j; k++) {
                if (k % 2 == 0) {
                    result *= k;
                }
            }
        }
    }

    public CalculatorThread(int executorServiceCount, int a) {
        this.executorService = Executors.newFixedThreadPool(executorServiceCount);;
        this.executorServiceCount = executorServiceCount;
        this.a = a;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void setJ(int a) {
        this.a = a;
    }

    public int getResult() {
        return result;
    }

    public void execute(){
        Task[] tasks = new Task[executorServiceCount];
        int i = 1;
        int j= a / executorServiceCount, g = a / executorServiceCount;
        for (int k = 0; k < executorServiceCount; k++) {
            if (k != executorServiceCount - 1) {
                tasks[k] = new Task(i, j);
                executorService.execute(tasks[k]);
            } else {
                tasks[k] = new Task(i, a);
                executorService.execute(tasks[k]);
            }
            i = j + 1;
            j += g;
        }
        try { Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println("Error : InterruptedException\n"+e.getMessage());
        }
        executorService.shutdown();
        for (Task task : tasks) {
            result *= task.getResult();
        }
    }
}
