Feature: Formulario de estudiante
  Como empleado administrativo
  Necesito ingresar al sistema los estudiantes de los nuevos ciclos academicos
  Con el fin de cumplir las politicas administrativas y de auditoria de la universidad

  Background:
    Given Que el empleado asministrativo se encuentra en la pagina web de los ingresos de estudiantes

  @regresion
  Scenario: Ingreso de un estudiamnte comn los campos obligatorios
    When el empleado administrativo ingresa los campos obligatorios y confirma la accion
    Then el sistema debera mostrar por panmtalla el registro del estudiante ingresado

  @regresion2
  Scenario: Ingreso de un estudiamnte comn los todos los campos
    When el empleado administrativo ingresa todos los campos y confirma la accion
    Then el sistema debera mostrar por panmtalla el registro completo del estudiante ingresado