@echo off
for /d %%i in ("D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-1\*") do (
  if not "%%i"=="%cd%" rd /s /q "%%i"
)
del /s /q "D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-1\*.*"

for /d %%i in ("D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-2\*") do (
  if not "%%i"=="%cd%" rd /s /q "%%i"
)
del /s /q "D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-2\*.*"

for /d %%i in ("D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-3\*") do (
  if not "%%i"=="%cd%" rd /s /q "%%i"
)
del /s /q "D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\kafka\broker-3\*.*"

for /d %%i in ("D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\zookeeper\data\*") do (
  if not "%%i"=="%cd%" rd /s /q "%%i"
)
del /s /q "D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\zookeeper\data\*.*"

for /d %%i in ("D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\zookeeper\transactions\*") do (
  if not "%%i"=="%cd%" rd /s /q "%%i"
)
del /s /q "D:\Bureau\workspace\IdeaProjects\food-ordering-system\infrastructure\docker-compose\volumes\zookeeper\transactions\*.*"
