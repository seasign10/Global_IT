import 'package:class_test/class_test.dart' as class_test;

class Car {
  int? maxSpeed;
  num? price;
  String? name;

  // 생성자. filed 초기화.
  Car(int this.maxSpeed, this.price, this.name);

  num? saleCar() {
    price = price! * 0.9;
    return price;
  }
}

void main(List<String> arguments) {
  Car bmw = Car(200, 10000, "BMW"); // instance 생성
  Car mercedes = Car(250, 15000, "Mercedes");
  Car audi = Car(220, 12000, "Audi");

  print(bmw.saleCar());
  print(mercedes.saleCar());
  print(audi.saleCar());
  print(bmw.price);
}
