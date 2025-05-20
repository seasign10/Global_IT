import 'package:flutter/material.dart';
import 'package:flutter_basic/widgets/column_widget.dart';
import 'package:flutter_basic/screen/home_screen.dart';

void main() {
  // 플러터 프레임워크가 앱을 실행할 준비가 될때까지
  // 기다림
  WidgetsFlutterBinding.ensureInitialized();

  runApp(
    MaterialApp(
      home: HomeScreen(),
    ),
  );
}








// void main() {
//   runApp(MyApp());
// }
//
// class MyApp extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       home: Scaffold(
//         body: Center(
//           child: ColumnWidgetExample(),
//         ),
//       ),
//     );
//   }
// }