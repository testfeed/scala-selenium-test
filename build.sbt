name := "scala-selenium-test"
organization := "com.equalexperts"

scalaVersion := "2.11.11"

version := "0.1.0"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "org.scalatest"           %% "scalatest"                       % "3.2.10"  % "test"
libraryDependencies += "com.dimafeng"            %% "testcontainers-scala-scalatest"  % "0.39.11"   % "test"
libraryDependencies += "org.scalatestplus"       %% "selenium-4-1"                   % "3.2.10.0" % "test"
libraryDependencies += "org.scalatest"           %% "scalatest-flatspec"              % "3.2.10" % "test"
libraryDependencies += "org.scalatest"           %% "scalatest-shouldmatchers"        % "3.2.10" % "test"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java"                    % "4.1.1" % "test"

Test / fork := true