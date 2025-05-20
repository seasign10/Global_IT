import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late final WebViewController controller;

  @override
  void initState() {
    super.initState();

    final PlatformWebViewControllerCreationParams params =
    const PlatformWebViewControllerCreationParams();

    controller = WebViewController.fromPlatformCreationParams(params)
      ..setJavaScriptMode(JavaScriptMode.unrestricted)
      ..loadRequest(Uri.parse('https://blog.codefactory.ai'));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.orange,
        title: const Text('Code Factory'),
        centerTitle: true,
        actions: [
          IconButton(
            onPressed: () {
              controller.loadRequest(Uri.parse('https://blog.codefactory.ai'));
            },
            icon: const Icon(Icons.home),
          ),
        ],
      ),
      body: WebViewWidget(controller: controller),
    );
  }
}
