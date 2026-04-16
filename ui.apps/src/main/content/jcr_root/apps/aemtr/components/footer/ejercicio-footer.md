# Ejercicio: Componente `footer`

## Contexto
El componente `footer` parte de una maqueta HTML estatica. El objetivo del ejercicio es convertir esa maqueta en un componente AEM configurable.

---

## Objetivo
Construir un footer editable desde AEM que incluya:

- Logo o marca del sitio
- Texto descriptivo
- Navegacion de enlaces automática - solo se puede contribuir el path de inicio
- Linea de copyright
- Enlaces a redes sociales con iconos

---

## Trabajo a realizar

1. Crear el dialogo del componente para que el autor pueda configurar el contenido.
2. Adaptar la maqueta a HTL.
3. Crear un Sling Model propio para preparar los datos que necesita la vista.
4. Permitir que la navegacion y las redes sociales sean configurables.

---

## Criterios de aceptacion

- El footer se puede editar desde el dialogo del componente.
- El HTML final se renderiza con HTL y datos reales del componente.
- El componente utiliza un Sling Model propio.
- El resultado mantiene una estructura visual similar a la maqueta inicial.
- El proyecto compila sin errores.
