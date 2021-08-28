package com.zyq.demo.java.shejimoshi;


//构建者模式
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories=val;
            return this;
        }
        public Builder fat(int val){
            fat=val;
            return this;
        }
        public Builder sodium(int val){
            sodium=val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate=val;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories=builder.calories;
        fat=builder.fat;
        sodium=builder.sodium;
        carbohydrate=builder.carbohydrate;
    }
}
class Test111{
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(20,4)
                .fat(10)
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
    }
}
