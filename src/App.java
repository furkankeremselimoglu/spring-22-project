import java.lang.Math;
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
        int p = 3;
        double[][] distanceMatrix = operator.distanceMatrix(facs, points);
        ArrayList<Facility> assignedFacilities = new ArrayList<>();
        ArrayList<Facility> unassignedFacilities = new ArrayList<>();
        HashMap<Facility, ArrayList<Point>> assignmentList = new HashMap<>();
        // Project created
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
        while(assignedFacilities.size() != p) {
            for(int i = 0; i < p; i++) {
                int[][] minIndexes = operator.findMinIndex(sumDistances);
                assignedFacilities.add(facs[minIndexes[0][0]]);
                unassignedFacilities.remove(facs[minIndexes[0][0]]);
                sumDistances[minIndexes[0][0]][0] = Double.MAX_VALUE;
            }
        }
        /*
        ArrayList<Point> remainPoints = new ArrayList<>();
        for(Point point : points) {
            remainPoints.add(point);
        }
        for(Facility facility : assignedFacilities) {
            assignmentList.put(facility, new ArrayList<Point>());
        }
        while(remainPoints.size() != 0) {
            double min = Double.MAX_VALUE;
            int minFacility_index = -1;
            int minPoint_index = -1;
            for (Facility facility : assignedFacilities) {
                for (Point point : remainPoints) {
                    double distance = operator.distFrom(facility.x, facility.y, point.x, point.y);
                    if (distance < min) {
                        min = distance;
                        minFacility_index = facility.id;
                        minPoint_index = point.id;
                    }
                }
            }
            remainPoints.remove(minPoint_index);
            assignmentList.get(facs[minFacility_index]).add(points[minPoint_index]);
        }
        System.out.println(assignmentList);

         */

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Execution Time is: " + elapsedTime + " nanoseconds");
    }
}



