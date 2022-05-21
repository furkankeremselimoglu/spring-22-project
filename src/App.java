import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import medianProblem.*;
public class App {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        Operators operator = new Operators();
        double[][] facs_coordinates = operator.createDistanceMatrix(5,2);
        double[][] points_coordinates = operator.createDistanceMatrix(20,2);
        Facility[] facs = new Facility[5];
        Point[] points = new Point [20];
        for (int i=0; i<facs.length;i++){
            Facility f1 = new Facility(i, facs_coordinates[i][0], facs_coordinates[i][1], 20*Math.random()+50);
            facs[i] = f1;
        }
        for (int i=0; i<points.length;i++){
            Point p1 = new Point (i, points_coordinates[i][0], points_coordinates[i][1], 2*Math.random()+1);
            points[i] = p1;
        }
        double[][] distanceMatrix = operator.distanceMatrix(facs, points);
        ArrayList<Facility> openedFacilities = new ArrayList<>();
        ArrayList<Facility> unassignedFacilities = new ArrayList<>();
        HashMap<Facility, ArrayList<Point>> assignmentList = new HashMap<>();
        // Project created
        int P = 3;
        for(Facility facility : facs) {
            unassignedFacilities.add(facility);
        }
        double[][] sumDistances = new double[facs.length][1];
        for(int i = 0; i < distanceMatrix.length; i++) {
            double sum = 0;
            for(int j = 0; j < distanceMatrix[0].length; j++) {
                sum += distanceMatrix[i][j];
            }
            sumDistances[i][0] = sum;
        }
        while(openedFacilities.size() != P) {
            int[][] minIndexes = operator.findMinIndex(sumDistances);
            openedFacilities.add(facs[minIndexes[0][0]]);
            unassignedFacilities.remove(facs[minIndexes[0][0]]);
            sumDistances[minIndexes[0][0]][0] = Double.MAX_VALUE;
        }
        for(Facility facility : openedFacilities) {
            assignmentList.put(facility, new ArrayList<>());
        }
        ArrayList<Point> remainPoints = new ArrayList<>();
        for(Point point : points) {
            remainPoints.add(point);
        }
        while(remainPoints.size() != 0) {
            int[][] minIndexes = new int[1][2];
            double min = Double.MAX_VALUE;
            for(int i = 0; i < distanceMatrix.length; i++) {
                for(int j = 0; j < distanceMatrix[0].length; j++) {
                    if(openedFacilities.contains(facs[i]) && remainPoints.contains(points[j])) {
                        if (distanceMatrix[i][j] < min){
                            min = distanceMatrix[i][j];
                            minIndexes[0][0] = i;
                            minIndexes[0][1] = j;
                        }
                    }
                }
            }
            assignmentList.get(facs[minIndexes[0][0]]).add(points[minIndexes[0][1]]);
            remainPoints.remove(points[minIndexes[0][1]]);
        }
        for(Facility facility : assignmentList.keySet()) {
            System.out.print(facility + " = ");
            System.out.println(assignmentList.get(facility));
        }
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        double mseconds = (double) elapsedTime / 1_000_000;
        DecimalFormat formatter = new DecimalFormat("#0.000");
        System.out.println("\nExecution Time is: " + formatter.format(mseconds) + " milliseconds");
    }
}



