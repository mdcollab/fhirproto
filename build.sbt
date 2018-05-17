name := "fhirproto"

version := "0.0.1"

scalaVersion := "2.11.12"

PB.targets in Compile := Seq(scalapb.gen() -> (sourceManaged in Compile).value)
PB.protoSources in Compile := Seq(baseDirectory.value / "protobuf" / "proto")
PB.includePaths in Compile -= baseDirectory.value / "protobuf" / "proto"
PB.includePaths in Compile += baseDirectory.value / "protobuf"

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)

licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("https://github.com/mdcollab/fhirproto"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/mdcollab/fhirproto"),
    "scm:git@github.com:mdcollab/fhirproto.git"
  )
)

developers := List(
  Developer(
    id    = "berrytj",
    name  = "Tom Berry",
    email = "tom@carbonhealth.com",
    url   = url("http://carbonhealth.com")
  )
)

publishMavenStyle := true

publishTo := Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")

lazy val root = project.in(file("."))
