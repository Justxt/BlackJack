"use client";

import BaseLayout from "../components/BaseLayout";
import { FaCreditCard, FaDollarSign, FaCalendarAlt, FaLock } from "react-icons/fa";
import { MdAttachMoney } from "react-icons/md";
import { useState } from "react";

export default function Withdraw() {
  const [credits, setCredits] = useState(0);
  const [totalPrice, setTotalPrice] = useState(0);
  const [showConfirmation, setShowConfirmation] = useState(false);
  const [withdrawalSuccessful, setWithdrawalSuccessful] = useState(false);

  // funcion para cambiar la cantidad de creditos
  const handleCreditsChange = (event) => {
    const newCredits = parseInt(event.target.value);
    setCredits(newCredits);
    setTotalPrice(newCredits);
  };

  // funcion para mostrar la confirmacion de retiro
  const handleConfirmation = () => {
    setShowConfirmation(true);
  };

  // funcion para cancelar el retiro
  const handleConfirmationCancel = () => {
    setShowConfirmation(false);
  };

  // funcion para aceptar el retiro
  const handleConfirmationAccept = () => {
    setShowConfirmation(false);
    setWithdrawalSuccessful(true);
    setTimeout(() => {
      setWithdrawalSuccessful(false);
    }, 1000); //notificacion de 1seg
  };

  return (
    <BaseLayout>
      <main className="flex flex-col items-center justify-center px-4 text-center">
        <div className="bg-gray-100 rounded-2xl shadow-2xl flex flex-col md:flex-row w-full max-w-4xl justify-center">
          <div className="w-full md:w-2/3 p-10">
            <div className="font-bold mb-2">
              <span className="text-red-500">BLACK</span>JACK
            </div>
            <h2 className="text-3xl font-bold text-red-500 mb-2">
              Retiro de Ganancias
            </h2>
            <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>
            <div className="py-10">
              <div className="flex flex-col items-center">
                <div className="border-2 bg-gray-100 w-full p-2 rounded-3xl flex items-center mt-5 mb-4">
                  <FaCreditCard className="text-gray-400 m-2" />
                  <input
                    type="text"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Número de Tarjeta"
                  />
                  <FaLock className="text-gray-400 m-2" />
                </div>

                <div className="flex justify-between mb-4">
                  <div className="border-2 bg-gray-100 w-1/3 p-2 rounded-3xl flex items-center">
                    <FaCalendarAlt className="text-gray-400 m-2" />
                    <input
                      type="text"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="MM/AA"
                    />
                  </div>
                  <div className="border-2 bg-gray-100 w-1/3 p-2 rounded-3xl flex items-center">
                    <FaLock className="text-gray-400 m-2" />
                    <input
                      type="text"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="CVV"
                    />
                  </div>
                </div>

                <div className="border-2 bg-gray-100 w-full p-2 rounded-3xl flex items-center mb-4">
                  <MdAttachMoney className="text-gray-400 m-2" />
                  <input
                    type="number"
                    min="0"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Cantidad de Créditos a Retirar"
                    value={credits}
                    onChange={handleCreditsChange}
                  />
                </div>

                <div className="text-gray-500 mb-4">
                  <span className="font-bold mr-2">Total:</span> {totalPrice} USD
                </div>

                <button
                  onClick={handleConfirmation}
                  className="bg-red-500 text-white py-2 px-4 rounded-full font-semibold hover:bg-red-600 mr-4"
                >
                  Retirar
                </button>
              </div>
            </div>
          </div>
        </div>
      </main>
      {showConfirmation && (
        <div className="fixed inset-0 flex items-center justify-center bg-gray-800 bg-opacity-50">
          <div className="bg-white p-8 rounded-xl shadow-md text-center">
            <h2 className="text-xl font-semibold mb-4">Confirmación de retiro</h2>
            <p className="mb-4">Estás seguro de que deseas retirar {credits} créditos por  {totalPrice} USD?</p>
            <div>
              <button
                onClick={handleConfirmationCancel}
                className="bg-gray-500 text-white py-2 px-4 rounded-full font-semibold hover:bg-gray-600 mr-4"
              >
                No
              </button>
              <button
                onClick={handleConfirmationAccept}
                className="bg-green-500 text-white py-2 px-4 rounded-full font-semibold hover:bg-green-600"
              >
                Sí
              </button>
            </div>
          </div>
        </div>
      )}
      {withdrawalSuccessful && (
        <div className="fixed bottom-4 right-4 bg-green-500 text-white py-2 px-4 rounded-md shadow-md">
          Retiro Realizado
        </div>
      )}
    </BaseLayout>
  );
}
