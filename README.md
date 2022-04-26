# Reproducer for `Lint` error in `lintAnalyzeDebug` in kotlin-android projects


Run with:
```bash
# Powershell
$env:LINT_PRINT_STACKTRACE="true"; ./gradlew clean build

# Bash
export LINT_PRINT_STACKTRACE=true; ./gradlew clean build

# CMD
set LINT_PRINT_STACKTRACE=true
.\gradlew clean build
```

Stacktrace:
```
java.lang.IllegalStateException: () -> kotlin.String
        at org.jetbrains.kotlin.asJava.classes.KtLightClassForFacadeImpl$Companion.createForFacadeNoCache(KtLightClassForFacadeImpl.kt:271)
        at org.jetbrains.kotlin.asJava.classes.FacadeCache$FacadeCacheData$cache$1.createValue(FacadeCache.kt:30)
        at org.jetbrains.kotlin.asJava.classes.FacadeCache$FacadeCacheData$cache$1.createValue(FacadeCache.kt:28)
        at com.intellij.util.containers.SLRUCache.get(SLRUCache.java:47)
        at org.jetbrains.kotlin.asJava.classes.FacadeCache.get(FacadeCache.kt:47)
        at org.jetbrains.kotlin.asJava.classes.KtLightClassForFacadeImpl$Companion.createForFacade(KtLightClassForFacadeImpl.kt:281)
        at org.jetbrains.kotlin.cli.jvm.compiler.CliKotlinAsJavaSupport.getFacadeClassesInPackage(CliKotlinAsJavaSupport.kt:40)
        at org.jetbrains.kotlin.asJava.LightClassUtilsKt.findFacadeClass(lightClassUtils.kt:58)
        at org.jetbrains.uast.kotlin.KotlinUFile$classes$2.invoke(KotlinUFile.kt:60)
        at org.jetbrains.uast.kotlin.KotlinUFile$classes$2.invoke(KotlinUFile.kt:17)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at org.jetbrains.uast.kotlin.KotlinUFile.getClasses(KotlinUFile.kt)
        at org.jetbrains.uast.UFile$DefaultImpls.accept(UFile.kt:84)
        at org.jetbrains.uast.kotlin.KotlinUFile.accept(KotlinUFile.kt:17)
        at com.android.tools.lint.client.api.UElementVisitor$visitFile$3.run(UElementVisitor.kt:284)
        at com.android.tools.lint.client.api.LintClient.runReadAction(LintClient.kt:1786)
        at com.android.tools.lint.client.api.LintDriver$LintClientWrapper.runReadAction(LintDriver.kt:2707)
        at com.android.tools.lint.client.api.UElementVisitor.visitFile(UElementVisitor.kt:280)
        at com.android.tools.lint.client.api.LintDriver$visitUastDetectors$1.run(LintDriver.kt:2033)
        at com.android.tools.lint.client.api.LintClient.runReadAction(LintClient.kt:1786)
        at com.android.tools.lint.client.api.LintDriver$LintClientWrapper.runReadAction(LintDriver.kt:2707)
        at com.android.tools.lint.client.api.LintDriver.visitUastDetectors(LintDriver.kt:2033)
        at com.android.tools.lint.client.api.LintDriver.visitUast(LintDriver.kt:2018)
        at com.android.tools.lint.client.api.LintDriver.runFileDetectors(LintDriver.kt:1404)
        at com.android.tools.lint.client.api.LintDriver.checkProject(LintDriver.kt:1168)
        at com.android.tools.lint.client.api.LintDriver.checkProjectRoot(LintDriver.kt:631)
        at com.android.tools.lint.client.api.LintDriver.access$checkProjectRoot(LintDriver.kt:156)
        at com.android.tools.lint.client.api.LintDriver$analyzeOnly$1.invoke(LintDriver.kt:445)
        at com.android.tools.lint.client.api.LintDriver$analyzeOnly$1.invoke(LintDriver.kt:438)
        at com.android.tools.lint.client.api.LintDriver.doAnalyze(LintDriver.kt:505)
        at com.android.tools.lint.client.api.LintDriver.analyzeOnly(LintDriver.kt:437)
        at com.android.tools.lint.LintCliClient$analyzeOnly$1.invoke(LintCliClient.kt:242)
        at com.android.tools.lint.LintCliClient$analyzeOnly$1.invoke(LintCliClient.kt:242)
        at com.android.tools.lint.LintCliClient.run(LintCliClient.kt:284)
        at com.android.tools.lint.LintCliClient.run$default(LintCliClient.kt:267)
        at com.android.tools.lint.LintCliClient.analyzeOnly(LintCliClient.kt:242)
        at com.android.tools.lint.Main.run(Main.java:1647)
        at com.android.tools.lint.Main.run(Main.java:274)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at com.android.build.gradle.internal.lint.AndroidLintWorkAction.invokeLintMainRunMethod(AndroidLintWorkAction.kt:93)
        at com.android.build.gradle.internal.lint.AndroidLintWorkAction.runLint(AndroidLintWorkAction.kt:82)
        at com.android.build.gradle.internal.lint.AndroidLintWorkAction.execute(AndroidLintWorkAction.kt:64)
        at org.gradle.workers.internal.DefaultWorkerServer.execute(DefaultWorkerServer.java:63)
        at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:66)
        at org.gradle.workers.internal.NoIsolationWorkerFactory$1$1.create(NoIsolationWorkerFactory.java:62)
        at org.gradle.internal.classloader.ClassLoaderUtils.executeInClassloader(ClassLoaderUtils.java:97)
        at org.gradle.workers.internal.NoIsolationWorkerFactory$1.lambda$execute$0(NoIsolationWorkerFactory.java:62)
        at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:44)
        at org.gradle.workers.internal.AbstractWorker$1.call(AbstractWorker.java:41)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
        at org.gradle.workers.internal.AbstractWorker.executeWrappedInBuildOperation(AbstractWorker.java:41)
        at org.gradle.workers.internal.NoIsolationWorkerFactory$1.execute(NoIsolationWorkerFactory.java:59)
        at org.gradle.workers.internal.DefaultWorkerExecutor.lambda$submitWork$2(DefaultWorkerExecutor.java:206)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runExecution(DefaultConditionalExecutionQueue.java:214)
        at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.runBatch(DefaultConditionalExecutionQueue.java:164)
        at org.gradle.internal.work.DefaultConditionalExecutionQueue$ExecutionRunner.run(DefaultConditionalExecutionQueue.java:131)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:61)
        at java.base/java.lang.Thread.run(Thread.java:829)

```