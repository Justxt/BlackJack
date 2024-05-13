"use client";

import BaseLayout from "../components/BaseLayout";

export default function Location() {

  // ubicacion de las sucursales
  const location1 =
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3989.802196473857!2d-78.46204888846806!3d-0.16289053543139914!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d590136d487c2f%3A0x494de438292c29b3!2sUniversidad%20de%20Las%20Am%C3%A9ricas%20-%20Campus%20UDLAPARK!5e0!3m2!1ses-419!2sec!4v1715560477745!5m2!1ses-419!2sec";
  const location2 =
    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3989.801320464487!2d-78.47521268846815!3d-0.16725693542814551!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d590740f0b2fa7%3A0x910b7814e50bfd4c!2sUniversidad%20de%20Las%20Am%C3%A9ricas%20-%20Campus%20Granados!5e0!3m2!1ses-419!2sec!4v1715560528887!5m2!1ses-419!2sec";

  return (
    <BaseLayout>
      <main className="flex flex-col items-center justify-center px-4 text-center">
        <div className="bg-gray-100 rounded-2xl shadow-2xl flex flex-col w-full max-w-4xl justify-center">
          <div className="md:flex md:flex-row">
            <div className="w-full md:w-1/2 p-10">
              <div className="font-bold mb-2">
                <span className="text-red-500">BLACK</span>JACK
              </div>
              <h2 className="text-3xl font-bold text-red-500 mb-2">
                Nuestras Sucursales
              </h2>
              <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>
              <div className="py-10">
                <div className="flex flex-col items-center">
                  <div className="mb-8">
                    <h3 className="text-xl font-bold mb-10">Sucursal 1</h3>
                    <div className="rounded-lg overflow-hidden shadow-md">
                      <iframe
                        title="map1"
                        width="100%"
                        height="300"
                        frameBorder="0"
                        src={location1}
                        allowFullScreen
                      ></iframe>
                    </div>
                    <p className="mt-4">Vía a Nayón, Quito 170124</p>
                  </div>
                </div>
              </div>
            </div>
            <div className="w-full md:w-1/2 p-10">
              <div className="py-10">
                <div className="flex flex-col items-center">
                  <div>
                    <h3 className="text-xl font-bold mb-10">Sucursal 2</h3>
                    <div className="rounded-lg overflow-hidden shadow-md">
                      <iframe
                        title="map2"
                        width="100%"
                        height="300"
                        frameBorder="0"
                        src={location2}
                        allowFullScreen
                      ></iframe>
                    </div>
                    <p className="mt-4">De Los Colimes esq, Quito 170513</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </BaseLayout>
  );
}
