import BaseLayout from "../components/BaseLayout";
import { PiPasswordFill } from "react-icons/pi";
import Link from "next/link";

export default function Security() {
  return (
    <BaseLayout>
      <main className="flex flex-col items-center justify-center px-20 text-center">
        <div className="bg-gray-100 rounded-2xl shadow-2xl flex w-screen max-w-4xl justify-center">
          {/* Seccion del login */}
          <div className="w-96 p-10">
            <div className="font-bold mb-2">
              <span className="text-red-500">BLACK</span>JACK
            </div>
            <h2 className="text-3xl font-bold text-red-500 mb-2">
              Cambiar Contraseña
            </h2>
            <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>
            <div className="py-10">
              <div className="flex flex-col items-center">
                {/* Aqui se crea el formulario de cambio de contraseña*/}
              <div className="border-2 bg-gray-100 w-72 p-2 rounded-3xl flex items-center mt-5 mb-4">
                  <PiPasswordFill className="text-gray-400 m-2" />
                  <input
                    type="password"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Contraseña Actual"
                  />
                </div>

                <div className="border-2 bg-gray-100 w-72 p-2 rounded-3xl flex items-center mb-4">
                  <PiPasswordFill className="text-gray-400 m-2" />
                  <input
                    type="password"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Nueva Contraseña"
                  />
                </div>

                <div className="border-2 bg-gray-100 w-72 p-2 rounded-3xl flex items-center mb-5">
                  <PiPasswordFill className="text-gray-400 m-2" />
                  <input
                    type="password"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Confirmar Contraseña"
                  />
                </div>
                <Link
                  href="#"
                  className="border-2 text-red-500 border-red-500 rounded-full px-12 py-2 mt-6 inline-block font-semibold hover:bg-white hover:text-black"
                >
                  Actualizar
                </Link>
              </div>
            </div>
          </div>
        </div>
      </main>
    </BaseLayout>
  );
}
