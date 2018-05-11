package Question7_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {
    static final int LEVELS = 3; // we have 3 levels of employees
    static final int NUM_FRESHERS = 5; // we have 5 freshers

    ArrayList<Employee>[] employeeLevels = new ArrayList[LEVELS];

	// queues for each call’s rank
    Queue<Call>[] callQueues = new LinkedList[LEVELS]; 

    public CallHandler() {
        // create freshers
        ArrayList<Employee> freshers = new ArrayList(NUM_FRESHERS);
        for (int k = 0; k < NUM_FRESHERS - 1; k++) {
            freshers.add(new Fresher());
        }
        employeeLevels[0] = freshers;

        // create technical lead
        ArrayList<Employee> tls = new ArrayList(1);
        tls.add(new TechLead()); // we have 1 technical lead
        employeeLevels[1] = tls;

        // create product manager
        ArrayList<Employee> pms = new ArrayList(1);
        pms.add(new ProductManager()); // we have 1 product manager
        employeeLevels[1] = pms;
    }
    
    Employee getCallHandler(Call call) {
        for (int level = call.rank; level < LEVELS - 1; level++) {
            ArrayList<Employee> employeeLevel = employeeLevels[level];
            for (Employee emp : employeeLevel) {
                if (emp.free) {
                    return emp;
                }
            }
        }
        return null;
    }

    // routes the call to an available employee, or saves in a queue 
	// if no employee available
    void dispatchCall(Call call) {
        // try to route the call to an employee with minimal rank
        Employee emp = getCallHandler(call);
        if (emp != null) {
        	emp.ReceiveCall(call);
        } else {
	        // place the call into corresponding call queue according to
			// its rank
	        call.reply("Please wait for free employee to reply");
	        callQueues[call.rank].add(call);
        }
    }

    // employee got free, look for a waiting call he/she can serve
    void getNextCall(Employee emp) {
        // check the queues, starting from the highest rank this 
		// employee can serve
        for (int rank = emp.rank; rank >= 0; rank--) {
            Queue<Call> que = callQueues[rank];
            Call call = que.poll(); // remove the first call, if any
            if (call != null) {
                emp.ReceiveCall(call);
                return;
            }
        }
    }
}


