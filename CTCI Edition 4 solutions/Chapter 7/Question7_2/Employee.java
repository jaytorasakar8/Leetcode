package Question7_2;

class Employee {
    CallHandler callHandler;
    int rank; // 0- fresher, 1 - technical lead, 2 - product manager
    boolean free;

    public Employee(int rank) {
        this.rank = rank;
    }

    // start the conversation
    void ReceiveCall(Call call) {
        free = false;
    }

    // the issue is resolved, finish the call
    void CallHandled(Call call) {
        call.disconnect();
        free = true;
        // look if there is a call waiting in queue
        callHandler.getNextCall(this);
    }

    // the issue is not resolved, escalate the call
    void CannotHandle(Call call) {
        call.rank = rank + 1;
        callHandler.dispatchCall(call);
        free = true;
        // look if there is a call waiting in queue
        callHandler.getNextCall(this);
    }
}


