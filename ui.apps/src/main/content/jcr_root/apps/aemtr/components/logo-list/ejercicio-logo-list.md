# Ejercicio: Componente `logo-list`

## Contexto
Este proyecto se utiliza con fines didácticos para aprender a desarrollar componentes en AEM. En este ejercicio, el alumnado deberá crear desde cero el componente **`logo-list`** bajo la ruta:

`/apps/aemtr/components/content/logo-list`

El objetivo es construir un componente que permita mostrar un listado de logotipos configurable desde el diálogo del componente.

---

## Objetivo del componente
Crear un componente que muestre una lista de logos, donde cada logo tenga:

- Una imagen (fileReference)
- Un texto alternativo (alt)
- Opcionalmente, un enlace al hacer clic en el logo

El autor debe poder:

- Añadir, eliminar y reordenar logos desde el diálogo del componente
- Configurar la imagen, el texto alternativo y el enlace de cada logo

---

## Requisitos funcionales

1. **Salida HTML**
   - El componente debe renderizarse como un contenedor con clase principal, por ejemplo: `aemtr-logo-list`.
   - Cada logo debe ir dentro de un elemento repetido (por ejemplo, `<li>` dentro de un `<ul>` o `<div>` dentro de un contenedor).
   - Si se configura un enlace, el logo debe ir envuelto en un `<a href="...">`.
   - Si no hay logos configurados, el componente debe mostrar un mensaje simple para autores (por ejemplo, "No hay logos configurados").

2. **Diálogo del componente (`_cq_dialog`)**
   - Utilizar un **multifield** para permitir añadir múltiples logos.
   - Cada ítem del multifield debe contener, como mínimo:
     - Un campo de selección de imagen (`fileReference`) usando un **pathfield** o **fileupload** apropiado para imágenes.
     - Un campo de texto para el **alt** de la imagen.
     - Un campo de texto para una **URL** opcional.

3. **Estructura de contenido**
   - Cada nodo de logo debe contener las propiedades necesarias (por ejemplo: `fileReference`, `alt`, `link`).

4. ** Sling Model **
    - Será necesaria la creación de un Sling Model para recoger el contenido y crear la lógica necesaria.
---
