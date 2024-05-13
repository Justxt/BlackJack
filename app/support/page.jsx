import Link from "next/link";
import BaseLayout from "../components/BaseLayout";
import { FaPhoneAlt } from "react-icons/fa";
import { FaLocationDot } from "react-icons/fa6";
import { MdEmail } from "react-icons/md";

export default function Support() {
  return (
    <BaseLayout>
      <div className="flex flex-col items-center justify-center h-full min-h-screen">
        <div className="flex flex-col md:flex-row md:space-x-8 space-y-6 md:space-y-0 bg-red-500 w-full max-w-4xl p-8 rounded-xl shadow-lg text-white">
          <div className="flex flex-col space-y-8">
            <div>
              <h1 className="font-bold text-4xl tracking-wide">Contactanos</h1>
              <p className="pt-5 text-red-100 text-base">
                Estamos aquí para resolver tus preguntas y
                ayudarte con cualquier problema que puedas tener. Ya sea que
                necesites asistencia con tus créditos, tengas preguntas sobre
                nuestros servicios o simplemente busques información general,
                
              </p>
              <p className="pt-4 text-red-100 text-base">
                Nuestro equipo de soporte está disponible de lunes a viernes de
                8:00 a 17:00 horas.
              </p>
            </div>

            <div className="flex items-center space-x-1">
              <FaPhoneAlt className="text-red-100 text-base" />
              <span>+593 987456321 - 02 3334444</span>
            </div>

            <div className="flex items-center space-x-2">
              <MdEmail className="text-red-100 text-lg" />
              <span>romsesito@udla.edu.ec</span>
            </div>

            <div className="flex items-center space-x-2">
              <FaLocationDot className="text-red-100 text-base" />
              <span>Vía a Nayón, Quito 170124</span>
            </div>
          </div>

          <div>
            <div className="bg-white rounded-xl shadow-lg p-8 text-gray-500 md:w-96">
              <form action="" className="flex flex-col space-y-3">
                <div>
                  <label htmlFor="" className="font-bold">
                    Ingresa tu nombre
                  </label>
                  <input
                    type="text"
                    placeholder="Nombre"
                    className="ring-1 ring-gray-200 rounded-md p-2 w-full outline-none focus:ring-2 focus:ring-red-500"
                  />
                </div>
                <div>
                  <label htmlFor="" className="font-bold">
                    Correo
                  </label>
                  <input
                    type="email"
                    placeholder="Ingresa tu correo electronico"
                    className="ring-1 ring-gray-200 rounded-md p-2 w-full outline-none focus:ring-2 focus:ring-red-500"
                  />
                </div>
                <div>
                  <label htmlFor="" className="font-bold">
                    Mensaje
                  </label>
                  <textarea
                    cols="3"
                    rows="10"
                    placeholder="Ingresa tu mensaje"
                    className="ring-1 ring-gray-200 rounded-md p-2 w-full outline-none focus:ring-2 focus:ring-red-500"
                  ></textarea>
                </div>
                <Link
                  href="#"
                  className="inline-block self-end font-bold rounded-full px-6 py-2 border text-red-500 border-red-500 hover:bg-white hover:text-black"
                >
                  Enviar
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </BaseLayout>
  );
}
