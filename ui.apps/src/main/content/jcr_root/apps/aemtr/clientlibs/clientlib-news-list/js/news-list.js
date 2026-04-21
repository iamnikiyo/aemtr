(function () {
  'use strict';

  const selector = '[data-news-list]';
  const endpoint = '/bin/news.json';

  const escapeHtml = (value) => String(value || '')
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#39;');

  const cardTemplate = (item) => {
    const title = escapeHtml(item.title);
    const tag = escapeHtml(item.tag);
    const text = escapeHtml(item.text);
    const image = escapeHtml(item.image);
    const imageMarkup = image
      ? `<div class="aspect-[16/10] overflow-hidden bg-slate-200">
          <img class="h-full w-full object-cover transition duration-300 group-hover:scale-105"
               src="${image}"
               alt="${title}">
        </div>`
      : '';
    const tagMarkup = tag
      ? `<p class="mb-3 w-fit border border-teal-200 bg-teal-50 px-2 py-1 text-xs
          font-bold uppercase tracking-[0.18em] text-teal-800">
          ${tag}
        </p>`
      : '';

    return `
      <article class="group flex h-full flex-col overflow-hidden rounded-md border border-slate-200 bg-white shadow-sm
          transition duration-200 hover:-translate-y-1 hover:border-teal-700 hover:shadow-xl">
        ${imageMarkup}
        <div class="flex flex-1 flex-col p-5">
          ${tagMarkup}
          <h3 class="mb-3 text-xl font-black leading-tight tracking-normal text-slate-950">${title}</h3>
          <p class="line-clamp-4 flex-1 text-sm leading-6 text-slate-600">${text}</p>
        </div>
      </article>
    `;
  };

  const setLoading = (container, isLoading) => {
    container.classList.toggle('opacity-60', isLoading);
    container.classList.toggle('pointer-events-none', isLoading);
  };

  const initNewsList = (container) => {
    const itemsContainer = container.querySelector('[data-news-items]');
    const error = container.querySelector('[data-news-error]');
    const empty = container.querySelector('[data-news-empty]');
    const root = container.dataset.newsRoot || '/content/dam/aemtr/news';

    if (!itemsContainer) {
      return;
    }

    const loadNews = () => {
      const params = new URLSearchParams({ root });

      setLoading(container, true);
      if (error) {
        error.classList.add('hidden');
      }
      if (empty) {
        empty.classList.add('hidden');
      }

      fetch(`${endpoint}?${params.toString()}`, { headers: { Accept: 'application/json' } })
        .then((response) => {
          if (!response.ok) {
            throw new Error(`News request failed with ${response.status}`);
          }
          return response.json();
        })
        .then((data) => {
          const items = Array.isArray(data.items) ? data.items : [];
          itemsContainer.innerHTML = items.map(cardTemplate).join('');
          if (empty) {
            empty.classList.toggle('hidden', items.length > 0);
          }
        })
        .catch(() => {
          itemsContainer.innerHTML = '';
          if (error) {
            error.classList.remove('hidden');
          }
        })
        .finally(() => setLoading(container, false));
    };

    loadNews();
  };

  document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll(selector).forEach(initNewsList);
  });
}());
