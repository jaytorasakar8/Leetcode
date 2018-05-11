package Question10_6;

public class Line {
	private static double epsilon = .0001;
	public double slope;
	public double intercept;
	private boolean infinite_slope = false;
	public Line(GraphPoint p, GraphPoint q) {
		if (Math.abs(p.x - q.x) > epsilon) { // if x’s are different
			slope = (p.y - q.y) / (p.x - q.x); // compute slope
			intercept = p.y - slope * p.x; // y intercept from y=mx+b
		} else {
			infinite_slope = true;
			intercept = p.x; // x-intercept, since slope is infinite
		}
	}
	
	public boolean isEqual(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}
	
	public void Print() {
		System.out.println("y = " + slope + "x + " + intercept);
	}
	
    @Override  
    public int hashCode()  {
        int sl = (int)(slope * 1000);
        int in = (int)(intercept * 1000);
        return sl | in;
    } 
    
    @Override  
        public boolean equals(Object o) {  
		Line l = (Line) o;
    	if (isEqual(l.slope, slope) && isEqual(l.intercept, intercept) 
			&& (infinite_slope == l.infinite_slope)) {
    		return true;
    	}
        return false;
    }      
}
