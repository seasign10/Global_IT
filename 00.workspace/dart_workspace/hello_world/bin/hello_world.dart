import 'package:hello_world/hello_world.dart' as hello_world;

// (1)
printInteger(int number) {
  print('The number is: $number');
}

// (2)
Future checkVersion() async {
  var version = await looupVersion();
  print(version);
}
int looupVersion() {
  return 12;
}

// (3)
Future<String> getVersionName() async {
  var versionName = await lookupVersionName();
  return versionName;
}
String lookupVersionName(){
  return 'Android Q';
}

// (4)
void printOne(){
  print('one');
}
void printTwo(){
  print('two');
}
void printThree(){
  print('three');
}

void main(List<String> arguments) {
  // (1)
  // var number = 42;
  // printInteger(number);

  // (2)
  // checkVersion();
  // print('end process');

  // (3)
  // getVersionName()의 리턴값이 넘어오면 후속작업이 이루어짐
  // getVersionName().then((value)=>{
  //   print(value)
  // });

  // (4)
  

  print('end process');
}
