#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.19.0")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.toYaml

val workflow =
  workflow(
    name = "Makefile workflow",
    on = listOf(Push()),
    sourceFile = __FILE__.toPath(),
  ) {
    job(id = "makefile_job", runsOn = UbuntuLatest) {
      uses(name = "Check out", action = CheckoutV3())
      run(name = "Check dependencies", command = "make versioncheck")
      run(name = "Run Tests", command = "make clean build tests")
    }
  }

println(workflow.toYaml())