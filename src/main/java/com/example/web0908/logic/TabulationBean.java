package com.example.web0908.logic;

import lombok.Data;

import java.util.List;
import java.util.stream.IntStream;


@Data
public class TabulationBean {
    private double start;
    private double finish;
    private double step;

    private List<Point> points;

    public TabulationBean(double start, double finish, double step) {
        this.start = start;
        this.finish = finish;
        this.step = step;

        int n = (int) (Math.round((finish - start) / step) + 1);
//        points = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            points.add(new Point(start + i * step, Math.sin(start + i * step)));
//        }
        points = IntStream.range(0, n).mapToDouble(i -> start + i * step).mapToObj(x -> new Point(x, Math.sin(x))).toList();
    }

    public Point getMaxPoint() {
        Point result = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getY() > result.getY()) {
                result = points.get(i);
            }
        }
        return result;
    }
}
