import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static final int MAX_COUNT_OF_TYPE = 26;

	public int leastInterval(char[] taskTypes, int n) {
		var result = 0;

		PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>(MAX_COUNT_OF_TYPE, (t1, t2)  -> t2.count - t1.count);
		Map<Character, Integer> taskMap = new HashMap<>(MAX_COUNT_OF_TYPE);
		for(var taskType: taskTypes) {
			var count = taskMap.getOrDefault(taskType, 0) + 1;
			taskMap.put(taskType, count);
		}

		for(var taskEntry: taskMap.entrySet()) {
			var newTask = new Task(taskEntry.getKey(), taskEntry.getValue());
			taskPriorityQueue.add(newTask);
		}


		List<Task> currentIteratorTask = new ArrayList<>(n+1);
		while (!taskPriorityQueue.isEmpty() && !taskPriorityQueue.peek().isCompleted()) {
			var isAllCompleted = true;
			for(int i = 0; i <= n; i++) {
				if (taskPriorityQueue.isEmpty() || taskPriorityQueue.peek().isCompleted()) {
					if (!isAllCompleted) {
						result += n + 1 - i;
					}
					break;
				}
				var task = taskPriorityQueue.poll();
				task.execute();
				isAllCompleted = isAllCompleted && task.isCompleted();
				currentIteratorTask.add(task);
				result++;
			}

			taskPriorityQueue.addAll(currentIteratorTask);
			currentIteratorTask.clear();
		}

		return result;
	}

	private class Task {
		private final char type;
		private int count;

		private Task(char type, int count) {
			this.type = type;
			this.count = count;
		}

		private void execute() {
			this.count--;
		}

		private boolean isCompleted() {
			return this.count == 0;
		}
	}
}
