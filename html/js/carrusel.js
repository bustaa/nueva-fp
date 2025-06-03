document.addEventListener('DOMContentLoaded', () => {
    const carrusel = document.getElementById('carrusel');
    const puntosContainer = document.getElementById('puntos');
    const eventos = [
        {
            titulo: "Taller de Energía Verde",
            fecha: "15 de Mayo, 2025",
            imagen: "images/evento1.png"
        },
        {
            titulo: "Jornada de Limpieza de Playas",
            fecha: "5 de Junio, 2025",
            imagen: "images/evento2.png"
        },
        {
            titulo: "Conferencia sobre Agricultura Sostenible",
            fecha: "20 de Julio, 2025",
            imagen: "images/evento3.png"
        },
        {
            titulo: "Campaña de Plantación de Árboles",
            fecha: "12 de Agosto, 2025",
            imagen: "images/evento4.png"
        },
        {
            titulo: "Sesión de Concienciación sobre el Reciclaje",
            fecha: "16 de Septiembre, 2025",
            imagen: "images/evento5.png"
        },
        {
            titulo: "Seminario sobre Acción Climática",
            fecha: "10 de Octubre, 2025",
            imagen: "images/evento6.png"
        },
        {
            titulo: "Exposición de Energías Renovables",
            fecha: "5 de Noviembre, 2025",
            imagen: "images/evento7.png"
        },
        {
            titulo: "Charla sobre la Conservación de la Vida Silvestre",
            fecha: "25 de Noviembre, 2025",
            imagen: "images/evento8.png"
        },
        {
            titulo: "Cumbre sobre Transporte Sostenible",
            fecha: "15 de Diciembre, 2025",
            imagen: "images/evento9.png"
        }
    ];

    function renderizarEventos() {
        carrusel.innerHTML = '';
        eventos.forEach((evento, index) => {
            const tarjeta = document.createElement('div');
            tarjeta.className = 'evento-tarjeta';
            tarjeta.innerHTML = `
                <img src="${evento.imagen}" alt="${evento.titulo}" class="evento-imagen">
                <div class="evento-contenido">
                    <h3 class="evento-titulo">${evento.titulo}</h3>
                    <p class="evento-fecha">${evento.fecha}</p>
                </div>
            `;
            carrusel.appendChild(tarjeta);
        });
    }

    renderizarEventos();

    const totalEventos = eventos.length;
    const eventosPorGrupo = 3;
    const totalGrupos = Math.ceil(totalEventos / eventosPorGrupo);

    for (let i = 0; i < totalGrupos; i++) {
        const punto = document.createElement('div');
        punto.className = 'punto';
        punto.dataset.index = i;
        if (i === 0) punto.classList.add('activo');
        puntosContainer.appendChild(punto);
    }

    const puntos = document.querySelectorAll('.punto');
    const botonIzquierda = document.querySelector('.carrusel-btn.izquierda');
    const botonDerecha = document.querySelector('.carrusel-btn.derecha');

    let posicionActual = 0;

    function actualizarCarrusel() {
        const tarjeta = document.querySelector('.evento-tarjeta');
        if (!tarjeta) return;
        const anchoTarjeta = tarjeta.offsetWidth + 30;
        if (posicionActual > totalEventos - eventosPorGrupo) {
            posicionActual = totalEventos - eventosPorGrupo;
        }
        if (posicionActual < 0) posicionActual = 0;

        const grupoActual = Math.floor(posicionActual / eventosPorGrupo);
        
        carrusel.style.transform = `translateX(${-posicionActual * anchoTarjeta}px)`;

        const tarjetas = document.querySelectorAll('.evento-tarjeta');
        tarjetas.forEach((tarjeta, index) => {
            const perteneceAlGrupoActual = Math.floor(index / eventosPorGrupo) === grupoActual;
            tarjeta.style.opacity = perteneceAlGrupoActual ? '1' : '0';
        });

        puntos.forEach((punto, index) => {
            punto.classList.toggle('activo', index === grupoActual);
        });

        botonIzquierda.style.display = posicionActual > 0 ? 'flex' : 'none';
        botonDerecha.style.display = posicionActual < totalEventos - eventosPorGrupo ? 'flex' : 'none';
    }

    botonDerecha.addEventListener('click', () => {
        if (posicionActual < totalEventos - eventosPorGrupo) {
            posicionActual += eventosPorGrupo;
            actualizarCarrusel();
        }
    });

    botonIzquierda.addEventListener('click', () => {
        if (posicionActual > 0) {
            posicionActual -= eventosPorGrupo;
            actualizarCarrusel();
        }
    });

    puntos.forEach(punto => {
        punto.addEventListener('click', () => {
            const index = parseInt(punto.dataset.index);
            posicionActual = index * eventosPorGrupo;
            actualizarCarrusel();
        });
    });

    actualizarCarrusel();
});